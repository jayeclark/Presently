package journal.gratitude.com.gratitudejournal.model

import com.google.common.truth.Truth.assertThat
import journal.gratitude.com.gratitudejournal.model.Milestone.Companion.isMilestone
import org.junit.Test

class TimelineItemsTest {

    @Test
    fun `GIVEN a milestone WHEN isMilestone is called THEN return true`() {
        val itemsToTest = listOf(5, 10, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 1000)
        for (item in itemsToTest) {
            assertThat(isMilestone(item)).isTrue()
        }
    }

    @Test
    fun `GIVEN a non milestone WHEN isMilestone is called THEN return false`() {
        val itemsToTest = listOf(0, 1, 11, 34, 2309, 4, 6)
        for (item in itemsToTest) {
            assertThat(isMilestone(item)).isFalse()
        }
    }
}