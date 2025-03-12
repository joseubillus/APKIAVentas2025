package com.example.modelo

class Producto {
    private var _id:String? = ""
    private var _nom:String? = ""
    private var _pre:Double? = 0.0
    private var _rang:Int? = 0
    private var _Img:String? = ""

    constructor()
    constructor(_id: String?, _nom: String?, _pre: Double?, _rang: Int?, _Img: String?) {
        this._id = _id
        this._nom = _nom
        this._pre = _pre
        this._rang = _rang
        this._Img = _Img
    }

    var getId:String?
        get() = _id
        set(value) { _id = value }

    var getNom:String?
        get() = _nom
        set(value) {_nom = value}

    var getPre:Double?
        get() = _pre
        set(value) {_pre = value}

    var getRang:Int?
        get() = _rang
        set(value) { _rang = value}

    var getImg:String?
        get() = _Img
        set(value) {_Img = value}
}