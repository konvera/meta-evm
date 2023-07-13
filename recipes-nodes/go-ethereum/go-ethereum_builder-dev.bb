include go-ethereum.inc

GO_INSTALL = "github.com/ethereum/go-ethereum/cmd/geth"
GO_IMPORT = "github.com/flashbots/builder"

SRCREV = "${AUTOREV}"
SRC_URI = "git://${GO_IMPORT};protocol=https;branch=main \
           file://init \
           "

INITSCRIPT_NAME = "geth"
INITSCRIPT_PARAMS = "defaults 99"

inherit update-rc.d

do_install:append() {
	install -d ${D}${sysconfdir}/init.d
        cp ${WORKDIR}/init ${D}${sysconfdir}/init.d/geth
        chmod 755 ${D}${sysconfdir}/init.d/geth
}
