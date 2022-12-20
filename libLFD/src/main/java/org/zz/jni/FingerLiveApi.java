package org.zz.jni;

public class FingerLiveApi {

    static {
        System.loadLibrary("FingerLiveApi");
    }

    /**
     * Initialize live fingerprint detect algorithm
     *
     * @param szConfigFile just input null string
     * @return 0 for success , otherwise failed.
     */
    public static native int initAlg(String szConfigFile);

    /**
     * free algorithm
     *
     * @return 0 for success , otherwise failed .
     */
    public static native int freeAlg();

    /**
     * Determine whether the input fingerprint image is a real fingerprint (Give a result)
     * <p>
     * Please ensure that the fingerprint area is greater than 45 points, otherwise it may be inaccurate
     *
     * @param pImage     raw image
     * @param nImgWidth  image width
     * @param nImgHeight image height
     * @param safeLevel  1~3 , 3 is the highest level
     *                   1 - FRR(False Reject Rate) is lower
     *                   2 - balance (Suggestion)
     *                   3 - FAR(False Accept Rate) is is lower
     * @param result     [out] , get result  at index 0 ,
     *                   0 - Fake Finger
     *                   1 - Real Finger
     * @return 0 for success , otherwise failed.
     */
    public static native int fingerLiveWithLevel(byte[] pImage, int nImgWidth, int nImgHeight, int safeLevel, int[] result);


    /**
     * Determine whether the input fingerprint image is a real fingerprint(Give a score from 0 to 100)
     * <p>
     * Please ensure that the fingerprint area is greater than 45 points, otherwise it may be inaccurate
     *
     * @param pImage     raw image
     * @param nImgWidth  image width
     * @param nImgHeight image height
     * @param score      [out] , get score (0~100) at index 0
     *                   Best pass score is 42
     * @return 0 for success , otherwise failed.
     */
    public static native int fingerLiveWithScore(byte[] pImage, int nImgWidth, int nImgHeight, int[] score);


    /**
     * ERROR CODE TABLE
     *
     * #define  ERR_OK					    0
     * #define  ERR_INIT				    1001
     * #define  ERR_NO_INIT			        1002
     * #define  ERR_LOAD_PARAM			    1003
     * #define  ERR_LOAD_MODEL			    1004
     * #define  ERR_IMAGE_BLOCK_NUM	        1005
     * #define	ERR_PARAMETER_SAFE_LEVEL	1011
     * #define  ERR_PARAMETER_IMAGE_SIZE	1012
     */
}
