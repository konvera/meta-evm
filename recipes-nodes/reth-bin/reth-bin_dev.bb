DESCRIPTION = "Copy flower to the image"
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI += "file://reth"
SRC_URI += "file://init"
S = "${WORKDIR}"

INITSCRIPT_NAME = "reth"
INITSCRIPT_PARAMS = "defaults 99"

inherit update-rc.d

do_install() {
  install -d ${D}${bindir}
  install -m 0777 reth ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d
        cp init ${D}${sysconfdir}/init.d/reth
        chmod 755 ${D}${sysconfdir}/init.d/reth
}
FILES_${PN} += "${bindir}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
