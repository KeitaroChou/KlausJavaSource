package idv.klaus.tools;

/**
 * Variable Assign
 * 
 * @author KlausChou
 *
 * <history>
 * 	20170922, initial
 * </history>
 */
public class VariableAssign {

	public static void main(String[] args) {
		
		// target
		String sql = "SELECT  OMP.SID_NO    					, OMP.FEE_LEVEL_SEQ    					, OMP.PERSONAL_ID    					, OMP.USER_ID    					, OT.TRANS_ID    					, OT.SELLER_MEMBER_SEQ    					, OT.TRANS_AMT    					, NVL(OT.REFUND_TOTAL_AMT, 0) AS REFUND_TOTAL_AMT    					, OT.UNHOLD_YN    					, OT.ESCROW_YN    					, OT.ESCROW_END_DATE    					, OT.UNHOLD_DATE    					, OT.ENTITY    					, OT.CCY    					, OT.PAYMENT_TYPE AS MAIN_PAYMENT_TYPE    					, OT.TRANS_STATUS    					, OT.TRANS_PHASE    					, OT.ARGUE_FINISH_DATE    					, OT.PAYMENT_CHANNEL    					, OT.API_TOKEN_NO    					, OTP.PAYMENT_AMT    					, OTP.PAYMENT_TYPE AS SUB_PAYMENT_TYPE    					, OTP.BANK_NO    					, NVL(OTP.REFUND_AMT, 0) AS REFUND_AMT    					, OTP.SID_MAIN_TRANS_ID    					, OTP.MODIFY_USER    					, OTP.COMPOSITE_ID    					, OTP.PAYMENT_ID AS PAYMENT_ID    					, OT.TRANS_ITEM AS TRANS_ITEM    					, NVL(OT.RELEASE_AMT,0) AS TRANS_RELEASE_AMT    					, OT.API_PLATFORM AS API_PLATFORM    					, NVL(OTP.PAYMENT_FEE,0) AS ORG_PAYMENT_FEE    					, NVL(OTP.RELEASE_AMT,0) AS PAYMENT_RELEASE_AMT    					, OTP.PAYMENT_TYPE AS PAYMENT_TYPE    					, OTP.PAYMENT_STATUS    					, OTP.PAYMENT_DEVICE    					, OT.TICKII_TRANS_NO    					, OTP.CARD_NO    					, OT.PAYMENT_TYPE_OPTION    					, OT.MK_REDUCE_FEE_SEQ    					, OT.MK_REDUCE_FEE_YN    					, OT.MK_ACTUAL_FEE    					, OT.API_AUTO_PUSH_MEMBER_SEQ    					, OT.API_PLATFORM_FEE    					, OT.CREATE_DATE  				FROM 	 OLP_TRANS OT    					, OLP_TRANS_PAYMENT OTP    					, OLP_MEMBER_PROFILE OMP WHERE 	OT.SELLER_MEMBER_SEQ = OMP.MEMBER_SEQ     		AND 	OTP.TRANS_ID = OT.TRANS_ID     		AND 	OT.UNHOLD_YN = ?     		AND 	OT.UNHOLD_DATE <= TO_DATE(?, 'YYYY/MM/DD HH24:MI:SS')     		AND 	(OT.TRANS_STATUS =? OR OT.TRANS_STATUS=?)         		AND 	(OTP.PAYMENT_STATUS IN (?, ?, ?))     		AND		(OTP.PAYMENT_AMT - NVL(OTP.REFUND_AMT,0) > 0)     		AND 	OT.TRANS_ITEM != ?     		AND		OT.CARD_COMPLETE_YN = ?";
		
		// value
		Object[] param = new Object[] {
				"N"
				, "2018/07/11 00:00:00"
				, "CUSTODY"
				, "COMPLETED"
				, "PAYMENT_COMPLETED"
				, "CARD_REQUEST_COMPLETED"
				, "PAYMENT_REQUEST_COMPLETED"
				, "TICKII"
				, "N"
		};
		
		StringBuffer result = new StringBuffer();
		int questionMarkCount = 0;
		
		try {
			for (int i = 0; i < sql.length(); i++) {
				char a = sql.charAt(i);
				if ('?' == a) {
					result.append("'" + param[questionMarkCount].toString() + "'");
					++questionMarkCount;
					continue;
				}
				result.append(a);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("====== error : value less then target ======");
			System.exit(0);
		}
		finally {
			if (questionMarkCount < param.length) {
				System.out.println("====== error : target less then value ======");
			}
			if (questionMarkCount == param.length) {
				System.out.println("====== result ======");
				System.out.println(result);
				System.out.println("====================");
			}
			printNumbers(param.length, questionMarkCount);
		}
	}
	
	public static void printNumbers(int param, int count) {
		System.out.println("param size = " + param);
		System.out.println("question mark count = " + count);
	}
}
