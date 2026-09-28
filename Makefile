MAIN := src/Main.java

LIBVER := 6.0.1-0
JAYLIB := lib/jaylib-$(LIBVER).jar

rodar: $(JAYLIB)
	java -cp $(JAYLIB) $(MAIN)

$(JAYLIB):
	wget -qP lib https://github.com/electronstudio/jaylib/releases/download/v$(LIBVER)/jaylib-$(LIBVER).jar

instalar: $(JAYLIB)

.PHONY: rodar instalar
