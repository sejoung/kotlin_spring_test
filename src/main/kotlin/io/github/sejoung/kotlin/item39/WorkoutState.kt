package io.github.sejoung.kotlin.item39

sealed class WorkoutState
data class Exercise(val name: String)

class PrepareState(val exercise: Exercise) : WorkoutState()
class ExerciseState(val exercise: Exercise) : WorkoutState()
object DoneState : WorkoutState()

fun List<Exercise>.toStates(): List<WorkoutState> =
    flatMap { exercise ->
        listOf(PrepareState(exercise), ExerciseState(exercise))
    } + DoneState

class WorkoutPresenter(states: List<WorkoutState>) {
    private var state: WorkoutState = states.first()
}

fun main() {
    val list = listOf("asd")
    list.first()
}
