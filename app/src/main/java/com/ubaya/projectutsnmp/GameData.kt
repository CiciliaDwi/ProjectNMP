package com.ubaya.projectutsnmp

object GameData {
    val game = listOf(
        GameBank(
            judul = "VALORANT",
            desc = "game tembak-tembakan juga tapi lebih seru lagi dan versi pc",
            imageId = R.drawable.valorant,
            achievement = listOf(
                AchievementBank("Juara 1 VCT Sea", 2024),
                AchievementBank("Juara 2 VCT Sea", 2023),
                AchievementBank("Juara 3 VCT Sea", 2022)
            ),
            team = listOf(
                TeamBank(
                    id = 1,
                    nama = "Onic Valo",
                    member = listOf(
                        MemberBank("Nanda", "Duelist","https://i.pravatar.cc/300?img=15"),
                        MemberBank("Cicil", "Initiator","https://i.pravatar.cc/300?img=59"),
                        MemberBank("Cecil", "Controller","https://i.pravatar.cc/300?img=58"),
                        MemberBank("Yehuda", "Sentinel","https://i.pravatar.cc/300?img=18")
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
                    id = 1,
                    nama = "Onic Valo",
                    member = listOf(
                        MemberBank("Riby", "Support","https://i.pravatar.cc/300?img=15"),
                        MemberBank("Elifel", "Tank","https://i.pravatar.cc/300?img=59"),
                        MemberBank("Nicole", "Fighter","https://i.pravatar.cc/300?img=58"),
                        MemberBank("Sara", "Mage","https://i.pravatar.cc/300?img=18")
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
                    id = 1,
                    nama = "Onic Valo",
                    member = listOf(
                        MemberBank("Audry", "Scout","https://i.pravatar.cc/300?img=15"),
                        MemberBank("Calista", "Support","https://i.pravatar.cc/300?img=59"),
                        MemberBank("Cindy", "Rusher","https://i.pravatar.cc/300?img=58"),
                        MemberBank("Grace", "Sniper","https://i.pravatar.cc/300?img=18")
                    )
                )
            )
        )
//        GameBank(
//            judul = "HAY DAY",
//            desc = "Permainan tempur, tembak-tembakan action yang seru sekali",
//            imageId = R.drawable.pubg1,
//            achievement = listOf(
//                AchievementBank("Juara 1 PMSL", 2024),
//                AchievementBank("Juara 2 PMSL", 2023),
//                AchievementBank("Juara 3 PMSL", 2023)
//            ),
//            team = listOf(
//                TeamBank(
//                    id = 1,
//                    nama = "Onic Valo",
//                    member = listOf(
//                        MemberBank("Audry", "Scout","https://i.pravatar.cc/300?img=15"),
//                        MemberBank("Calista", "Support","https://i.pravatar.cc/300?img=59"),
//                        MemberBank("Cindy", "Rusher","https://i.pravatar.cc/300?img=58"),
//                        MemberBank("Grace", "Sniper","https://i.pravatar.cc/300?img=18")
//                    )
//                )
//            )
//        )
    )
}