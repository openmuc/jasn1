/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class PostalCode implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public BerNumericString numericCode = null;
	public BerPrintableString printableCode = null;
	
	public PostalCode() {
	}

	public PostalCode(byte[] code) {
		this.code = code;
	}

	public PostalCode(BerNumericString numericCode, BerPrintableString printableCode) {
		this.numericCode = numericCode;
		this.printableCode = printableCode;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (printableCode != null) {
			codeLength += printableCode.encode(reverseOS, true);
			return codeLength;
		}
		
		if (numericCode != null) {
			codeLength += numericCode.encode(reverseOS, true);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int tlvByteCount = 0;
		boolean tagWasPassed = (berTag != null);

		if (berTag == null) {
			berTag = new BerTag();
			tlvByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerNumericString.tag)) {
			numericCode = new BerNumericString();
			tlvByteCount += numericCode.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerPrintableString.tag)) {
			printableCode = new BerPrintableString();
			tlvByteCount += printableCode.decode(is, false);
			return tlvByteCount;
		}

		if (tagWasPassed) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (numericCode != null) {
			sb.append("numericCode: ").append(numericCode);
			return;
		}

		if (printableCode != null) {
			sb.append("printableCode: ").append(printableCode);
			return;
		}

		sb.append("<none>");
	}

}

