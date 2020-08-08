package ssdemo

import grails.plugins.orm.auditable.Auditable

class Color implements Auditable {

    String nombre

    static constraints = {
        nombre nullable: false
    }

    static mapping = {
    }
}
