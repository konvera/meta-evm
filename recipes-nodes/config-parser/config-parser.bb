SUMMARY = "Cloud Init Custom Data JSON Parser for Environment Variables"
DESCRIPTION = "A Python script that parses a JSON file and exports key-value pairs as environment variables"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/:"
SRC_URI = "file://config_parser.py \
           file://setup_env.sh \
           file://fetch-config.sh"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/config_parser.py ${D}${bindir}
    install -m 0755 ${S}/setup_env.sh ${D}${bindir}
    
    install -d ${D}${sysconfdir}/profile.d
    echo "source /usr/bin/setup_env.sh" > ${D}${sysconfdir}/profile.d/json_env_vars.sh

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/fetch-config.sh ${D}${sysconfdir}/init.d/fetch-config
}

DEPENDS += "python3"
RDEPENDS:${PN} += "python3-core python3-json curl"

inherit update-rc.d

INITSCRIPT_NAME = "fetch-config"
INITSCRIPT_PARAMS = "defaults 90" 
