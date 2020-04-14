package com.martha.core_base.model

class Announcement {

    private var title: String = ""
    private var name: String = ""
    private var schoolName: String = ""
    private var date: String = ""
    private var time: String = ""
    private var status: String = ""

    constructor(title: String, name: String, schoolName: String, date: String, time: String, status: String) {
        this.title = title
        this.name = name
        this.schoolName = schoolName
        this.date = date
        this.time = time
        this.status = status
    }

    fun getTitle(): String {
        return name
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String){
        this.name = name
    }

    fun getSchoolName(): String {
        return schoolName
    }

    fun setSchoolName(schoolName: String){
        this.schoolName = schoolName
    }

    fun getDate(): String {
        return date
    }

    fun setDate(date: String){
        this.date = date
    }

    fun getTime(): String {
        return time
    }

    fun setTime(time: String){
        this.time = time
    }

    fun getStatus(): String {
        return status
    }

    fun setStatus(status: String){
        this.status = status
    }

}