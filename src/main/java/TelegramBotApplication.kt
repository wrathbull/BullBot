import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage
import org.telegram.telegrambots.meta.api.objects.Update
import java.sql.Timestamp
import java.util.Calendar


class TelegramBotApplication

fun main() {
    ApiContextInitializer.init()
    TelegramBotsApi().registerBot(Bot())
}

class Bot: TelegramLongPollingBot() {
    override fun getBotToken() = "1512973133:AAFT3YaFEAHA98L4GlwwYCgDycGa-lbNhFc"

    override fun getBotUsername() = "AlienBull4Girlsbot"

    override fun onUpdateReceived(update: Update) {
        val matchResult = Regex(".*http.*").find(update.message.text)

        val original = Timestamp(0)
        val cal = Calendar.getInstance()
        cal.timeInMillis = original.time
        cal.add(Calendar.SECOND, update.message.date)
        val later = Timestamp(cal.time.time)

        if (matchResult != null && update.message.from.id != 777000 && update.message.from.userName != "levilovna"
            && update.message.from.userName != "me_blushsupreme" && update.message.from.userName != "valentine_gb") {
//            println(matchResult.groups.get(0)?.value.toString())
            execute(SendMessage().setChatId("-1001480358999").setText(update.message.text + " BY: " + update.message.from.firstName + " " +
                    update.message.from.lastName + " " + update.message.from.userName + " " + later))
            execute(DeleteMessage(update.message.chatId, update.message.messageId))//.setMessageId(update.message.messageId))
        }
        else
        {
//            execute(SendMessage().setChatId(update.message.chatId).setText(update.message.text + " else "))
//            println("yes else")
        }
    }
}