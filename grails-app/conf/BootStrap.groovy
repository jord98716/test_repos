class BootStrap {

	def authenticateService

	def init = { servletContext ->
		def role = new Role(authority:'ROLE_USER', description:'User').save()
		def user = new User(username:'demo',
				    userRealName:'Demo User',
				    passwd:authenticateService.encodePassword('demo'),
				    enabled:true,
				    email:'demo@demo.com')
		user.addToAuthorities(role)
		user.save()
        
        def o1 = new Owner(firstName:'Jordan', lastName:'Howe').save()
        def o2 = new Owner(firstName:'Joe', lastName:'Bloggs').save()
        def o3 = new Owner(firstName:'Jane', lastName:'Doe').save()

        def b1 = new Book(title:'A Catcher in the Rye', author:'J.D. Salinger', isbn:'1234567891')
        //b1.save()
        def b2 = new Book(title:'Dianetics', author:'L. Ron Hubbard', isbn:'9876543219')
        //b2.save()
        def b3 = new Book(title:'Silent Spring', author:'Rachel Carson', isbn:'2342342342')
        //b3.save()
        def b4 = new Book(title:"All the President's Men", author:'Bob Woodward', isbn:'3453453453')
        //b4.save()
        def b5 = new Book(title:'The Bourne Ultimatum', author:'Robert Ludlum', isbn:'4564564564')
        //b5.save()
        def b6 = new Book(title:'Zen and the Art of Motorcycle Maintenance', author:'Robert Pirsig', isbn:'1231231231')
        //b6.save()
        
        o1.addToBooks(b1).addToBooks(b2)
        //b1.setOwner(o1)
        //b2.setOwner(o1)
        o2.addToBooks(b3).addToBooks(b4)
        //b3.setOwner(o2)
        //b4.setOwner(o2)
        o3.addToBooks(b5).addToBooks(b6)
        //b5.setOwner(o3)
        //b6.setOwner(o3)

//        b1.save(flush:true)
//        b2.save(flush:true)
//        b3.save(flush:true)
//        b4.save(flush:true)
//        b5.save(flush:true)
//        b6.save(flush:true)

	}
	def destroy = {
	}
} 
