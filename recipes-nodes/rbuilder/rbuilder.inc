SUMMARY = "Reth"
DESCRIPTION = "reth is the command line interface for running a full ethereum node implemented in rust."
LICENSE="CLOSED"
LIC_FILES_CHKSUM=""

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

DEPENDS += "openssl"
RDEPENDS:${PN} += "openssl"

# temporary fix to build rbuilder with libffi - host gcc means we won't get reproducibility
export CC = "${CCACHE}${HOST_PREFIX}gcc ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
export CFLAGS = "${HOST_CFLAGS}"
export LDFLAGS = "${HOST_LDFLAGS}"

export BINDGEN_EXTRA_CLANG_ARGS
BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${WORKDIR}/recipe-sysroot -I${WORKDIR}/recipe-sysroot/usr/include"

S = "${WORKDIR}/git"
