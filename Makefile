all:
	$(MAKE) -C src/metal

merge:
	git checkout master
	git checkout ponyatov -- Makefile src
	rm -rf docs
	