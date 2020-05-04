/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.wab.generator.internal.connection;

import com.liferay.portal.kernel.security.xml.SecureXMLFactoryProviderUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.UnsecureSAXReaderUtil;
import com.liferay.portal.security.xml.SecureXMLFactoryProviderImpl;
import com.liferay.portal.util.FileImpl;
import com.liferay.portal.util.HttpImpl;
import com.liferay.portal.util.PropsImpl;
import com.liferay.portal.xml.SAXReaderImpl;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.UnknownServiceException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Gregory Amerson
 */
public class WabURLConnectionTest {

	@BeforeClass
	public static void setUpClass() {
		FileUtil fileUtil = new FileUtil();

		fileUtil.setFile(new FileImpl());

		HttpUtil httpUtil = new HttpUtil();

		httpUtil.setHttp(new HttpImpl());

		PropsUtil.setProps(new PropsImpl());

		SAXReaderUtil saxReaderUtil = new SAXReaderUtil();

		SAXReaderImpl secureSAXReaderImpl = new SAXReaderImpl();

		secureSAXReaderImpl.setSecure(true);

		saxReaderUtil.setSAXReader(secureSAXReaderImpl);

		SecureXMLFactoryProviderUtil secureXMLFactoryProviderUtil =
			new SecureXMLFactoryProviderUtil();

		secureXMLFactoryProviderUtil.setSecureXMLFactoryProvider(
			new SecureXMLFactoryProviderImpl());

		UnsecureSAXReaderUtil unsecureSAXReaderUtil =
			new UnsecureSAXReaderUtil();

		unsecureSAXReaderUtil.setSAXReader(new SAXReaderImpl());

		URL.setURLStreamHandlerFactory(
			protocol -> new URLStreamHandler() {

				@Override
				protected URLConnection openConnection(URL url) {
					return new URLConnection(url) {

						@Override
						public void connect() {
						}

					};
				}

			});
	}

	@Test(expected = UnknownServiceException.class)
	public void testWabURLConnectionRequiredParams() throws IOException {
		WabURLConnection wabURLConnection = new WabURLConnection(
			null, null,
			new URL(
				"webbundle:/path/to/foo?Web-ContextPath=foo&protocol=file"));

		wabURLConnection.getInputStream();
	}

	@Test(expected = UnknownServiceException.class)
	public void testWabURLConnectionRequiredParamsCompatibilityMode()
		throws Exception {

		String uriString = _getURIString("/classic-theme.autodeployed.war");

		WabURLConnection wabURLConnection = new WabURLConnection(
			null, null,
			new URL("webbundle:" + uriString + "?Web-ContextPath=foo"));

		wabURLConnection.getInputStream();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWabURLConnectionRequiredParamsMissing() throws Exception {
		WabURLConnection wabURLConnection = new WabURLConnection(
			null, null, new URL("webbundle:/path/to/foo?Web-ContextPath=foo"));

		wabURLConnection.getInputStream();
	}

	private String _getURIString(String fileName) throws URISyntaxException {
		URL url = WabURLConnectionTest.class.getResource(fileName);

		URI uri = url.toURI();

		return uri.toASCIIString();
	}

}