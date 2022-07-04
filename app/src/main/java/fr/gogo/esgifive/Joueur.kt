package fr.gogo.esgifive

import kotlin.random.Random

class Player(val name: String,
             val skills: Double,
             val isGoal: Boolean,
             var haveBall: Boolean = false){

    fun scoreGoal(goalKeeper: Player):Boolean{
        println(this.name + " shoot...")

        if( (this.skills - goalKeeper.skills) + 0.1 <= Random.nextDouble(0.0,1.0)){
            println(goalKeeper.name + " kept the ball")
            goalKeeper.takeBall()
            return false
        }

        println("GOAAAAL!!!")
        return true
    }

    fun pass(p: Player){
        this.leaveBall()
        p.takeBall()

        if(this.name == p.name){
            println(this.name + " tente de dribbler ")
        }else{
            println(this.name + " fait la passe à " + p.name)
        }

    }

    fun leaveBall(){
        haveBall = false
    }

    fun takeBall(){
        haveBall = true
    }
}