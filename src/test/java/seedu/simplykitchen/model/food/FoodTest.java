package seedu.simplykitchen.model.food;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.simplykitchen.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.simplykitchen.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BREAD;
import static seedu.simplykitchen.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.simplykitchen.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.simplykitchen.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.simplykitchen.testutil.Assert.assertThrows;
import static seedu.simplykitchen.testutil.TypicalFood.APPLE_PIE;
import static seedu.simplykitchen.testutil.TypicalFood.BREAD;

import org.junit.jupiter.api.Test;

import seedu.simplykitchen.testutil.FoodBuilder;

public class FoodTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Food food = new FoodBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> food.getTags().remove(0));
    }

    @Test
    public void isSameFood() {
        // same object -> returns true
        assertTrue(APPLE_PIE.isSameFood(APPLE_PIE));

        // null -> returns false
        assertFalse(APPLE_PIE.isSameFood(null));

        // different phone and email -> returns false
        Food editedApplePie = new FoodBuilder(APPLE_PIE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(APPLE_PIE.isSameFood(editedApplePie));

        // different description -> returns false
        editedApplePie = new FoodBuilder(APPLE_PIE).withDescription(VALID_DESCRIPTION_BREAD).build();
        assertFalse(APPLE_PIE.isSameFood(editedApplePie));

        // same description, same phone, different attributes -> returns true
        editedApplePie = new FoodBuilder(APPLE_PIE).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(APPLE_PIE.isSameFood(editedApplePie));

        // same description, same email, different attributes -> returns true
        editedApplePie = new FoodBuilder(APPLE_PIE).withPhone(VALID_PHONE_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(APPLE_PIE.isSameFood(editedApplePie));

        // same description, same phone, same email, different attributes -> returns true
        editedApplePie = new FoodBuilder(APPLE_PIE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(APPLE_PIE.isSameFood(editedApplePie));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Food aliceCopy = new FoodBuilder(APPLE_PIE).build();
        assertTrue(APPLE_PIE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(APPLE_PIE.equals(APPLE_PIE));

        // null -> returns false
        assertFalse(APPLE_PIE.equals(null));

        // different type -> returns false
        assertFalse(APPLE_PIE.equals(5));

        // different food -> returns false
        assertFalse(APPLE_PIE.equals(BREAD));

        // different description -> returns false
        Food editedApplePie = new FoodBuilder(APPLE_PIE).withDescription(VALID_DESCRIPTION_BREAD).build();
        assertFalse(APPLE_PIE.equals(editedApplePie));

        // different phone -> returns false
        editedApplePie = new FoodBuilder(APPLE_PIE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(APPLE_PIE.equals(editedApplePie));

        // different email -> returns false
        editedApplePie = new FoodBuilder(APPLE_PIE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(APPLE_PIE.equals(editedApplePie));

        // different address -> returns false
        editedApplePie = new FoodBuilder(APPLE_PIE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(APPLE_PIE.equals(editedApplePie));

        // different tags -> returns false
        editedApplePie = new FoodBuilder(APPLE_PIE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(APPLE_PIE.equals(editedApplePie));
    }
}
