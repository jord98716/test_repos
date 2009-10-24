//import org.codehaus.groovy.grails.plugins.springsecurity.Secured;
import org.springframework.security.annotation.Secured;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.flex.remoting.RemotingExclude;

//@RemotingDestination(channels=["amf","secure-amf"])
class TestService {

	boolean transactional = true

	//@Secured(["ROLE_USER"])
	//@RemotingInclude
	def echo(txt) {
		return "Grails -> "+txt;
	}
	
	//@RemotingExclude
	def majicEyesOnly() {
		return "Majestic 12";
	}

	def fetchAllBooks() {
		Book.list()
	}

	def saveBook(Book book) {
		Book stored = Book.get(book.id)
		stored.properties = book.properties
		if (!stored.hasErrors() && stored.validate()){
			stored.save()
		}
	}

    def fetchAllOwners() {
        Owner.list()
    }

	def saveOwner(Owner owner) {
		Owner stored = Owner.get(owner.id)
		//stored.properties = owner.properties
		stored.firstName = owner.firstName
        stored.lastName = owner.lastName
        if (!stored.hasErrors() && stored.validate()){
			stored.save()
		}
	}
}
