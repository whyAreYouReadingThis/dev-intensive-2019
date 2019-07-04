package ru.skillbranch.devintensive.extensions


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