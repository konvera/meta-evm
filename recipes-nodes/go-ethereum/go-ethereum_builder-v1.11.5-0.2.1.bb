include go-ethereum.inc

GO_INSTALL = "github.com/ethereum/go-ethereum/cmd/geth"
GO_IMPORT = "github.com/flashbots/builder"

SRCREV = "d3b034a29d5f2fd662f8abdfa33c31e536e74570"
SRC_URI = "git://${GO_IMPORT};protocol=https;branch=main \
           file://init \
           file://0001-go-ethereum-tls.patch;patchdir=src/${GO_WORKDIR} \
           file://0002-protect.patch;patchdir=src/${GO_WORKDIR} \
           file://0003-cloud-init-user-data.patch;patchdir=src/${GO_WORKDIR} \
           "

INITSCRIPT_NAME = "geth"
INITSCRIPT_PARAMS = "defaults 99"

inherit update-rc.d

do_install:append() {
	install -d ${D}${sysconfdir}/init.d
        cp ${WORKDIR}/init ${D}${sysconfdir}/init.d/geth
        chmod 755 ${D}${sysconfdir}/init.d/geth
}
