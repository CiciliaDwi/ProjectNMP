
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectutsnmp.ListMemberActivity
import com.ubaya.projectutsnmp.TeamBank
import com.ubaya.projectutsnmp.databinding.ItemTeamBinding

class TeamsAdapter(private val teams: List<TeamBank>, private val onTeamClick: (TeamBank) -> Unit) : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {
    class TeamViewHolder(val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(team: TeamBank, onClick: (TeamBank) -> Unit) {
            binding.textTeamName.text = team.nama

            // Handle item click
            binding.root.setOnClickListener {
                onClick(team) // Pass the selected team back to the activity
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team, onTeamClick)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ListMemberActivity::class.java)
            intent.putParcelableArrayListExtra("member", ArrayList(team.member))
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return teams.size
    }
}
