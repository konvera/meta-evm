DESCRIPTION = "Copy flower to the image"
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI += "file://flower"
SRC_URI += "file://example_single_request.json"
SRC_URI += "file://example_single_response.json"
SRC_URI += "file://example_state.json"
S = "${WORKDIR}"
do_install() {
  install -d ${D}${bindir}
  install -m 0777 flower ${D}${bindir}
  install -m 0777 example_single_request.json ${D}${bindir}
  install -m 0777 example_single_response.json ${D}${bindir}
  install -m 0777 example_state.json ${D}${bindir}
}
FILES_${PN} += "${bindir}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
#INSANE_SKIP_${PN} = "ldflags"
#INSANE_SKIP_${PN}-dev = "ldflags"
