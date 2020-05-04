/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.util.test;

import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.wiki.configuration.WikiGroupServiceConfiguration;
import com.liferay.wiki.engine.creole.internal.parser.ast.WikiPageNode;
import com.liferay.wiki.engine.creole.internal.parser.parser.Creole10Lexer;
import com.liferay.wiki.engine.creole.internal.parser.parser.Creole10Parser;
import com.liferay.wiki.engine.creole.internal.util.WikiEngineCreoleComponentProvider;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import org.mockito.Mockito;

/**
 * @author Roberto Díaz
 */
public class CreoleTestUtil {

	public static WikiEngineCreoleComponentProvider
		getWikiEngineCreoleComponentProvider() {

		WikiEngineCreoleComponentProvider wikiEngineCreoleComponentProvider =
			new WikiEngineCreoleComponentProvider();

		ReflectionTestUtil.invoke(
			wikiEngineCreoleComponentProvider, "activate", new Class<?>[0]);

		WikiGroupServiceConfiguration wikiGroupServiceConfiguration =
			Mockito.mock(WikiGroupServiceConfiguration.class);

		Mockito.when(
			wikiGroupServiceConfiguration.parsersCreoleSupportedProtocols()
		).thenReturn(
			new String[] {"ftp://", "http://", "https://", "mailto", "mms://"}
		);

		wikiEngineCreoleComponentProvider.setWikiGroupServiceConfiguration(
			wikiGroupServiceConfiguration);

		return wikiEngineCreoleComponentProvider;
	}

	public static WikiPageNode getWikiPageNode(
		String fileName, Class<?> clazz) {

		Creole10Parser creole10Parser = null;

		try {
			creole10Parser = getCreole10Parser(fileName, clazz);

			creole10Parser.wikipage();
		}
		catch (IOException ioException) {
			throw new RuntimeException("File " + fileName + " does not exist");
		}
		catch (RecognitionException recognitionException) {
			throw new RuntimeException("Unable to parse " + fileName);
		}

		return creole10Parser.getWikiPageNode();
	}

	protected static Creole10Parser getCreole10Parser(
			String fileName, Class<?> clazz)
		throws IOException {

		InputStream inputStream = clazz.getResourceAsStream(
			"dependencies/" + fileName);

		ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);

		Creole10Lexer creole10Lexer = new Creole10Lexer(antlrInputStream);

		CommonTokenStream commonTokenStream = new CommonTokenStream(
			creole10Lexer);

		return new Creole10Parser(commonTokenStream);
	}

}