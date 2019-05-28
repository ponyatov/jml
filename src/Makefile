
A=~/jml/src
B=~/metaL/Android/app/src/main/java/io/github/ponyatov

SYNC = rsync -vru --files-from=sync.files 

sync:
	$(SYNC) $A $B
	$(SYNC) $B $A
