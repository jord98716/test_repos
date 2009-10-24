class Owner {
    String firstName
    String lastName

    static constraints = {
        firstName(blank:false)
        lastName(blank:false)
    }

    static hasMany = [ books : Book ]

    static mapping = {
        books lazy:false
    }

    String toString() {
        firstName + " " + lastName
    }
}
