class Book {
    String title
    String isbn
    String author

    static constraints = {
        isbn(blank:false, unique:true)
        title(blank:false)
        author(blank:false)
        //owner(nullable:true)
    }

    //static belongsTo = [ owner : Owner ]
    static belongsTo = Owner

//    static mapping = {
//        owner lazy:false
//    }
//
//    static fetchMode = [owner:'eager'] // w/o this line of code the error persist

    String toString() {
        isbn + " " +  title + " " + author + " owned by: " + owner 
    }
}
