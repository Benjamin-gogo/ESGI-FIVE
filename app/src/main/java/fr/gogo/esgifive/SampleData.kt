package fr.gogo.esgifive

class SampleData {
}

class DataTeams {
    companion object {
        fun getTeams(): ArrayList<Team> {
            return arrayListOf(
                Team("MOCKITO", createRandomTeam()),
                Team("A2PAS ZOO", createRandomTeam()),
                Team("CHELSEA FC", createRandomTeam()),
                Team("SANANES TEAM", createRandomTeam()),
                Team("BOULAN GERIE", createRandomTeam()),
                Team("LES BLACK PANTHERS", createRandomTeam()),
                Team("CHIPS LAYS", createRandomTeam()),
                Team("MY TEAM ESGI", createRandomTeam()),
            )
        }

        fun getTeamsNames(): ArrayList<String>{
            lateinit var listNames: ArrayList<String>
            for(i in 0..getTeams().size)
                listNames.add(getTeams()[i].name)

            return listNames
        }

        private fun createRandomTeam(): ArrayList<Player> {
            var randomTeam: ArrayList<Player> = arrayListOf()
            var randomGoalKeeper: Player = DataPlayers.getGoalKeepers().random()
            var randomPlayer: Player


            for (i in 0..3) {
                randomPlayer = DataPlayers.getPlayers().random()
                randomTeam.add(randomPlayer)
            }

            randomTeam.add(randomGoalKeeper)
            return randomTeam
        }
    }
}

class DataPlayers {
    companion object {
        fun getPlayers(): ArrayList<Player> {
            return arrayListOf(
                Player("Ronaldinho", 0.9, false),
                Player("Messi", 0.6, false),
                Player("Neymar", 0.8, false),
                Player("MBappe", 0.9, false),
                Player("Nixoninho", 0.6, false),
                Player("Benji", 0.5, false),
                Player("Vallee", 0.5, false),
                Player("Okun David", 0.7, false),
                Player("Salayna", 0.9, false),
                Player("Raph", 0.8, false),
                Player("Tiem", 0.8, false)
            )
        }

        fun getGoalKeepers(): ArrayList<Player> {
            return arrayListOf(
                Player("Neuer", 0.5, true),
                Player("Casillas", 0.4, true),
                Player("Oliver Kahn", 0.4, true),
                Player("Donnaruma", 0.2, true)
            )
        }
    }
}