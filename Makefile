all: src/metal/Lexer.java

src/metal/Lexer.java: src/metal/Lexer.ragel src/metal/Makefile
	$(MAKE) -C src/metal
	
sync:
	$(MAKE) -C src sync

merge:
	git checkout master
	git checkout ponyatov -- Makefile src
	rm -rf docs
