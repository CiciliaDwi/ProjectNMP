package com.ubaya.projectutsnmp

object GameData {
    val game = listOf(
        GameBank(
            judul = "VALORANT",
            desc = "Game tembak-tembakan juga tapi lebih seru lagi dan versi PC",
            imageId = R.drawable.valorant,
            achievement = listOf(
                AchievementBank("Juara 1 VCT Sea", 2024),
                AchievementBank("Juara 2 VCT Sea", 2023),
                AchievementBank("Juara 3 VCT Sea", 2022)
            ),
            team = listOf(
                TeamBank(
                    nama = "Team Jangan Telat",
                    member = listOf(
                        MemberBank("Nanda", "Duelist", R.drawable.pictnmp),
                        MemberBank("Cicil", "Initiator", R.drawable.pictnmp),
                        MemberBank("Cecil", "Controller", R.drawable.pictnmp),
                        MemberBank("Yehuda", "Sentinel", R.drawable.pictnmp)
                    )
                ),
                TeamBank(
                    nama = "Team Pasti Menang",
                    member = listOf(
                        MemberBank("Nanda", "Duelist", R.drawable.pictnmp),
                        MemberBank("Cicil", "Initiator", R.drawable.pictnmp),
                        MemberBank("Cecil", "Controller", R.drawable.pictnmp),
                        MemberBank("Yehuda", "Sentinel", R.drawable.pictnmp)
                    )
                )
            )
        ),
        GameBank(
            judul = "Mobile Legend",
            desc = "Game 5 vs 5, yang seru, bisa bermain bersama teman juga",
            imageId = R.drawable.moba,
            achievement = listOf(
                AchievementBank("Juara 1 MPL ID", 2024),
                AchievementBank("Juara 2 MPL ID", 2024),
                AchievementBank("Juara 3 MPL ID", 2023)
            ),
            team = listOf(
                TeamBank(
                    nama = "Team ML Banget",
                    member = listOf(
                        MemberBank("Riby", "Support", R.drawable.pictnmp),
                        MemberBank("Elifel", "Tank", R.drawable.pictnmp),
                        MemberBank("Nicole", "Fighter", R.drawable.pictnmp),
                        MemberBank("Sara", "Mage", R.drawable.pictnmp)
                    )
                ),
                TeamBank(
                    nama = "Team GACOR",
                    member = listOf(
                        MemberBank("Nanda", "Duelist", R.drawable.pictnmp),
                        MemberBank("Cicil", "Initiator", R.drawable.pictnmp),
                        MemberBank("Cecil", "Controller", R.drawable.pictnmp),
                        MemberBank("Yehuda", "Sentinel", R.drawable.pictnmp)
                    )
                )
            )
        ),
        GameBank(
            judul = "PUBG Mobile",
            desc = "Permainan tempur, tembak-tembakan action yang seru sekali",
            imageId = R.drawable.pubg1,
            achievement = listOf(
                AchievementBank("Juara 1 PMSL", 2024),
                AchievementBank("Juara 2 PMSL", 2023),
                AchievementBank("Juara 3 PMSL", 2023)
            ),
            team = listOf(
                TeamBank(
                    nama = "Team PRO-G",
                    member = listOf(
                        MemberBank("Audry", "Scout", R.drawable.pictnmp),
                        MemberBank("Calista", "Support", R.drawable.pictnmp),
                        MemberBank("Cindy", "Rusher", R.drawable.pictnmp),
                        MemberBank("Grace", "Sniper", R.drawable.pictnmp)
                    )
                ),
                TeamBank(
                    nama = "Team Nomor 1",
                    member = listOf(
                        MemberBank("Nanda", "Duelist", R.drawable.pictnmp),
                        MemberBank("Cicil", "Initiator", R.drawable.pictnmp),
                        MemberBank("Cecil", "Controller", R.drawable.pictnmp),
                        MemberBank("Yehuda", "Sentinel", R.drawable.pictnmp)
                    )
                )
            )
        )
    )
}