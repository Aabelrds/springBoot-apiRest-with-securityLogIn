package com.example.demo.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "MI.CLAVE.SECRETA.12345";
	
	public static final String PASSPRIVATE_STRING ="MIIEugIBADANBgkqhkiG9w0BAQEFAASCBKQwggSgAgEAAoIBAQDL2ppckkZ7YXJ9\r\n"
			+ "m+NDHs/wanV2bukKT6bHxyT9Mvf10bnDBx9bgHLWPyuQAt8giolbtIhiz7mVMzDA\r\n"
			+ "ky6BNgr0Yi+TQe2tVuuDR7NikZp7Cu90RN+pvNZIMJuBdn73bMYGjDKUiiRXvFMx\r\n"
			+ "HK6tRnDjrL34ZYP+KwyxCN/muF8cWKFDaAY3a96x8aVYJHeh6h7vFVPesfMYLuWU\r\n"
			+ "rQFojmf9DbTc5D7gRdobfGV4TI8apZ/o/w1sJPq1cbC1qdZHennQrsSzBucGKfU6\r\n"
			+ "AIXJzGglxIedN3ebi+6bWdpV7kUEAMvcDU8AT8+X2lozOM/sRKI6fNxIOklZ/hPA\r\n"
			+ "fPac3ZnHAgMBAAECggEAPotyG9/nTxidY4uOJTxRaT6Ijo9F4duBXL8tip/2Mw4n\r\n"
			+ "U/6d8NmOokxcZcFzywymSyQvSj3Yfz3nAdbGiG9X2hY76Y7rSOknti4sDByHTKQU\r\n"
			+ "xtQQ2YeuKRT8yTJdjzVo5n5iUG+36dFGpwVZVKGNplUMLiebYUK9EJ4b8DJ2QAAm\r\n"
			+ "8PQgarTk/STWOJgv8UbtKavI0Z/qLKVdOmgwF9NI1S/TtXdWiQYt/auys3t01MH5\r\n"
			+ "RLrfzgW44D4XeM6Wk/xV2t/nugkMClSoSnkRuGHaqIddRNQAbtwkV81Cnk3a/Y4d\r\n"
			+ "iHMpCYVHKA3aE8uCsZ/UQLHnzKkbZRk24f1KC6NEpQKBgQDVxZHfGtjSRt2egXRS\r\n"
			+ "xQyqPoqroeGgtwpxfQhTtR+PQLEiU5/h8nY9X19CXuJV+SqPMpKLOZhZsk+VnGoC\r\n"
			+ "V2ruNbd5ESbHrfU3QA0oMZudOiCy7DPnvos7uavZk7naiLWGib/634Chy/Xo3F0L\r\n"
			+ "REJClJbdr2YtQs6RvDX2KyJx3QKBgQD0H30G70jFIjyd3iMfT+9Ens6mdnCyknHl\r\n"
			+ "FOGwLVH5zM8LEzABVVxG2x6AQp5fwXFQBIldPtJ9BUKC5oAi8UpZHZnu/eiTQrtR\r\n"
			+ "0E0VHuO/P0K3jYVu8PO/h/WCxca60AVxgWzttO5CwTeCF5gc3yFbgo22wh5DmBDb\r\n"
			+ "W569qwnJ8wJ/OMhB9wEqlrA8Ld41B8dPlekG7JATXp1AKOUNUS7LM0H7yyJrVZkR\r\n"
			+ "zzuGEhsiA7Qrmd3VDyY9UZYLjbH+dqDBxoR+N6pWorOSbxqUZBjJPPoztVMIdoYm\r\n"
			+ "dbbb7u9Obr3hedsdI4Y6pL+IklH2ZQe8kfLmH/x3J46XUB6uNrU+cQKBgETnhmCo\r\n"
			+ "tX9+9GESzBMQetaBhI6Tq6ebki44wKL7h8HcPyw/FDOsJkmRm4BUTWN1tEgDn8oD\r\n"
			+ "62GCVI2iBdTXCkcxBbvhSv4Vvc2P39HwUBQxBOHOPjVcKVCMTY3FyRv9jyvEfjxx\r\n"
			+ "7zZEVyiPBE5R5JZxuRI2pFgr2cYwjBO47SBlAoGAFkvm00Uw3GrOaaCzIo8MfwMs\r\n"
			+ "fQ3U7rJcjqaA2ZoGPKeJ7082upgObjYataBylpz9zt+ovLzWQ6vdYeRClf7GfhHU\r\n"
			+ "TfTJ1IofVBp5GUvARYaKbVexio7C8Ew20H2jBcq2BsPcXcUDaqv3S2mqe5zwCfgB\r\n"
			+ "azVRDCnEKsccftBvL3E=\r\n";
	
	public static final String PASSSTRINGPUBLICA_STRING ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy9qaXJJGe2FyfZvjQx7P\r\n"
			+ "8Gp1dm7pCk+mx8ck/TL39dG5wwcfW4By1j8rkALfIIqJW7SIYs+5lTMwwJMugTYK\r\n"
			+ "9GIvk0HtrVbrg0ezYpGaewrvdETfqbzWSDCbgXZ+92zGBowylIokV7xTMRyurUZw\r\n"
			+ "46y9+GWD/isMsQjf5rhfHFihQ2gGN2vesfGlWCR3oeoe7xVT3rHzGC7llK0BaI5n\r\n"
			+ "/Q203OQ+4EXaG3xleEyPGqWf6P8NbCT6tXGwtanWR3p50K7EswbnBin1OgCFycxo\r\n"
			+ "JcSHnTd3m4vum1naVe5FBADL3A1PAE/Pl9paMzjP7ESiOnzcSDpJWf4TwHz2nN2Z\r\n"
			+ "xwIDAQAB\r\n";
}
