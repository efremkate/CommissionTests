import org.junit.Assert.*
import ru.netology.*

class MainKtTest {

    private val delta = 0.1

    @org.junit.Test
    fun calculateVisaPayMin() {
        val amount = 100_000
        val excepted = 3500.0
        val result = visaPay(amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculateVisaPayCommission() {
        val amount = 750_000
        val excepted = 5625.0
        val result = visaPay(amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun masterPayIsZero() {
        val amount = 50_000
        val amountMonth = 0
        val excepted = 0.0
        val result = masterPay(amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun masterPayIsNotZero() {
        val amount = 80_000
        val amountMonth = 0
        val excepted = 50.0
        val result = masterPay(amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun vkPaymentValidationZero() {
        val amount = 4_000
        val amountMonth = 0
        val excepted = true
        val result = vkPaymentValidation(amountMonth, amount)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun vkPaymentValidationFalseOne() {
        val amount = 42_000
        val amountMonth = 0
        val excepted = false
        val result = vkPaymentValidation(amountMonth, amount)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun vkPaymentValidationFalseMonth() {
        val amount = 10_000
        val amountMonth = 60_000
        val excepted = false
        val result = vkPaymentValidation(amountMonth, amount)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun cardPaymentValidationZero() {
        val amount = 120_000
        val amountMonth = 0
        val amountDay = 0
        val excepted = true
        val result = cardPaymentValidation(amountMonth, amountDay, amount)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun cardPaymentValidationFalseDay() {
        val amount = 190_000
        val amountMonth = 0
        val amountDay = 160_000
        val excepted = false
        val result = cardPaymentValidation(amountMonth, amountDay, amount)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun cardPaymentValidationFalseMonth() {
        val amount = 120_000
        val amountMonth = 700_000
        val amountDay = 0
        val excepted = false
        val result = cardPaymentValidation(amountMonth, amountDay, amount)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun calculatingZero() {
        val paymentSystem = "vkPay"
        val amountMonth = 0
        val amount = 0
        val excepted = 0.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingVisa3500() {
        val paymentSystem = "Visa"
        val amountMonth = 0
        val amount = 10_000
        val excepted = 3500.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingVisa() {
        val paymentSystem = "Visa"
        val amountMonth = 0
        val amount = 500_000
        val excepted = 3750.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingMir() {
        val paymentSystem = "Mir"
        val amountMonth = 0
        val amount = 678_000
        val excepted = 5085.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingMir3500() {
        val paymentSystem = "Mir"
        val amountMonth = 0
        val amount = 27_000
        val excepted = 3500.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingMaestroZero() {
        val paymentSystem = "Maestro"
        val amountMonth = 0
        val amount = 10_000
        val excepted = 0.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingMaestro() {
        val paymentSystem = "Maestro"
        val amountMonth = 4_000
        val amount = 80_000
        val excepted = 74.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingMastercardZero() {
        val paymentSystem = "Mastercard"
        val amountMonth = 0
        val amount = 19_000
        val excepted = 0.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun calculatingMastercard() {
        val paymentSystem = "Mastercard"
        val amountMonth = 25_000
        val amount = 90_000
        val excepted = 260.0
        val result = calculating(paymentSystem, amountMonth, amount)

        assertEquals(excepted, result, delta)
    }

    @org.junit.Test
    fun validateCommissionVk() {
        val paymentSystem = "vkPay"
        val amountMonth = 0
        val amount = 10_000
        val amountDay = 0
        val excepted = true
        val result = validateCommission(paymentSystem, amountMonth, amount, amountDay)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun validateCommissionVisa() {
        val paymentSystem = "Visa"
        val amountMonth = 0
        val amount = 100_000
        val amountDay = 0
        val excepted = true
        val result = validateCommission(paymentSystem, amountMonth, amount, amountDay)

        assertEquals(excepted, result)
    }

    @org.junit.Test
    fun validateCommissionMir() {
        val paymentSystem = "Mir"
        val amountMonth = 0
        val amount = 57_000
        val amountDay = 0
        val excepted = true
        val result = validateCommission(paymentSystem, amountMonth, amount, amountDay)

        assertEquals(excepted, result)


    }

    @org.junit.Test
    fun validateCommissionMastercard() {
        val paymentSystem = "Mastercard"
        val amountMonth = 0
        val amount = 14_000
        val amountDay = 0
        val excepted = true
        val result = validateCommission(paymentSystem, amountMonth, amount, amountDay)

        assertEquals(excepted, result)
    }


    @org.junit.Test
    fun validateCommissionMaestro() {
        val paymentSystem = "Maestro"
        val amountMonth = 0
        val amount = 98_000
        val amountDay = 0
        val excepted = true
        val result = validateCommission(paymentSystem, amountMonth, amount, amountDay)

        assertEquals(excepted, result)
    }
}