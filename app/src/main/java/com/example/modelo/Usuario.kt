package com.example.modelo

class Usuario {
    private var _id:Int? = 0
    private var _nom:String? = null
    private var _pas:String? = null

    constructor()
    constructor(_id: Int?, _nom: String?, _pas: String?) {
        this._id = _id
        this._nom = _nom
        this._pas = _pas
    }

    var getId:Int?
        get() = _id
        set(value) {_id = value}

    var getNom:String?
        get() = _nom
        set(value) {_nom = value}

    var getPas:String?
        get() = _pas
        set(value) {_pas = value}
}