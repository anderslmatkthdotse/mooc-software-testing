package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CaesarShiftCipherTest {

    @ParameterizedTest(name = "{0} shift {1} -> {2}")
    @CsvSource({
            "'ab3',0,'invalid'", // ugly - use exception
            "'abc',0,'abc'",
            "'abc',1,'bcd'",
            "'abc',-1,'zab'",
            "'xyz',1,'yza'",
            "'xyz',27,'yza'",
            "'abc',-27,'zab'"

    })
    public void testCaesar(String msg, int shift, String encrMsg) {
        CaesarShiftCipher csc = new CaesarShiftCipher();
        String result = csc.encrypt(msg, shift);
        Assertions.assertEquals(encrMsg, result);
    }

    @Test
    public void msgIsNull() {
        assertThrows(NullPointerException.class, () -> {
            String result = new CaesarShiftCipher().encrypt(null, 1);
        });
    }
}
