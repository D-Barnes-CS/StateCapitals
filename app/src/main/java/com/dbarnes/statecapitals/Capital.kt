package com.dbarnes.statecapitals
//class header, including primary constructor
class Capital(state : String, capitalCity : String) {
    //properties
    var state : String = ""
        get() = field
        set(value) {
            field = value
        }
    var capitalCity : String = ""
        get() = field
        set(value) {
            field = value
        }
    //set the property values to the corresponding
//parameters of the primary constructor
    init {
        this.state = state
        this.capitalCity = capitalCity
    }
}