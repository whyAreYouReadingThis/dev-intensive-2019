package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView(): UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще ни разу не был" else if (isOnline) "Онлайн" else "Последний раз был в сети ${lastVisit!!.humanizeDiff()}"

    return UserView(
        id = id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        status = status)
}

fun String.truncate(count: Int = 16): String {
    if (count > this.trim().length)
        return this.trim()
    return this.substring(0, count).trim() + "..."
}

fun String.stripHtml(): String {

    var str = this

    while (str.indexOf("<") != -1 && str.indexOf(">") != -1) {
        val startIndex = str.indexOf("<")
        val endIndex = str.indexOf(">")
        val replacement = ""
        val toBeReplaced = str.substring(startIndex, endIndex + 1)
        str = str.replace(toBeReplaced, replacement)
    }

    str = str.replace("\\s+".toRegex()," ")

    return str.trim()
}