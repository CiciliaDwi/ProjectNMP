package com.ubaya.projectutsnmp

data class GameBank(var imageId: Int,
                    var judul: String,
                    var desc: String,
                    var achievement: List<AchievementBank>,
                    var team: List<TeamBank>)