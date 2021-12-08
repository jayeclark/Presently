package journal.gratitude.com.gratitudejournal.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDate

sealed class TimelineItem

@Entity(tableName = "entries")
data class Entry(
    @PrimaryKey
    val entryDate: LocalDate,
    val entryContent: String
): TimelineItem()

data class Milestone(val number: Int,
                     val numString: String): TimelineItem() {

    companion object {
        private val specialMilestones = setOf(5, 10)

        fun isMilestone(number: Int): Boolean {
            return specialMilestones.contains(number) || (number > 0 && number % 25 == 0)
        }

        fun create(number: Int): Milestone {
            require(isMilestone(number))

            return Milestone(number, number.toString())
        }

    }
}

