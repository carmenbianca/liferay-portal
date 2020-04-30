/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.google.drive.constants;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alejandro Tardín
 */
public class DLOpenerGoogleDriveMimeTypesTest {

	@Test
	public void testSupportsDocumentMimeTypes() {
		_assertIsSupportedGoogleDocsDocument("application/pdf", "pdf");
		_assertIsSupportedGoogleDocsDocument("application/rtf", "rtf");
		_assertIsSupportedGoogleDocsDocument("application/text", "txt");
		_assertIsSupportedGoogleDocsDocument(
			"application/vnd.oasis.opendocument.text", "odt");
		_assertIsSupportedGoogleDocsDocument(
			"application/vnd.openxmlformats-officedocument.wordprocessingml." +
				"document",
			"docx");
		_assertIsSupportedGoogleDocsDocument("text", "txt");
		_assertIsSupportedGoogleDocsDocument("text/html", "html");
		_assertIsSupportedGoogleDocsDocument("text/plain", "txt");
	}

	@Test
	public void testSupportsPresentationFiles() {
		_assertIsSupportedGoogleDocsPresentation(
			"application/vnd.oasis.opendocument.presentation", "odp");
		_assertIsSupportedGoogleDocsPresentation(
			"application/vnd.openxmlformats-officedocument.presentationml." +
				"presentation",
			"pptx");
	}

	@Test
	public void testSupportsSpreadsheetMimeTypes() {
		_assertIsSupportedGoogleDocsSpreadsheet(
			"application/vnd.oasis.opendocument.spreadsheet", "ods");
		_assertIsSupportedGoogleDocsSpreadsheet(
			"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
			"xlsx");
		_assertIsSupportedGoogleDocsSpreadsheet("text/csv", "csv");
		_assertIsSupportedGoogleDocsSpreadsheet(
			"text/tab-separated-values", "tsv");
	}

	private void _assertIsSupportedGoogleDocsDocument(
		String mimeType, String extension) {

		_assertMimeTypeSupported(
			DLOpenerGoogleDriveMimeTypes.APPLICATION_VND_GOOGLE_APPS_DOCUMENT,
			mimeType, extension);
	}

	private void _assertIsSupportedGoogleDocsPresentation(
		String mimeType, String extension) {

		_assertMimeTypeSupported(
			DLOpenerGoogleDriveMimeTypes.
				APPLICATION_VND_GOOGLE_APPS_PRESENTATION,
			mimeType, extension);
	}

	private void _assertIsSupportedGoogleDocsSpreadsheet(
		String mimeType, String extension) {

		_assertMimeTypeSupported(
			DLOpenerGoogleDriveMimeTypes.
				APPLICATION_VND_GOOGLE_APPS_SPREADSHEET,
			mimeType, extension);
	}

	private void _assertMimeTypeSupported(
		String googleDocsMimeType, String mimeType, String extension) {

		Assert.assertEquals(
			googleDocsMimeType,
			DLOpenerGoogleDriveMimeTypes.getGoogleDocsMimeType(mimeType));

		Assert.assertTrue(
			mimeType + " is not supported",
			DLOpenerGoogleDriveMimeTypes.isGoogleMimeTypeSupported(mimeType));

		Assert.assertEquals(
			"." + extension,
			DLOpenerGoogleDriveMimeTypes.getMimeTypeExtension(mimeType));
	}

}