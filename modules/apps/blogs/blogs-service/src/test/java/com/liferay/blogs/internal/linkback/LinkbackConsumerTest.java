/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.internal.linkback;

import com.liferay.blogs.linkback.LinkbackConsumer;
import com.liferay.portal.kernel.comment.CommentManager;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.registry.BasicRegistryImpl;
import com.liferay.registry.RegistryUtil;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author André de Oliveira
 */
public class LinkbackConsumerTest {

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		RegistryUtil.setRegistry(new BasicRegistryImpl());

		_linkbackConsumer = new LinkbackConsumerImpl();

		ReflectionTestUtil.setFieldValue(
			_linkbackConsumer, "_commentManager", _commentManager);

		ReflectionTestUtil.setFieldValue(_linkbackConsumer, "_http", _http);
	}

	@Test
	public void testDeleteCommentIfBlogEntryURLNotInReferrer()
		throws Exception {

		String url = RandomTestUtil.randomString();

		Mockito.when(
			_http.URLtoString(url)
		).thenReturn(
			RandomTestUtil.randomString()
		);

		long commentId = RandomTestUtil.randomLong();

		_linkbackConsumer.addNewTrackback(
			commentId, url, RandomTestUtil.randomString());

		_linkbackConsumer.verifyNewTrackbacks();

		Mockito.verify(
			_commentManager
		).deleteComment(
			commentId
		);

		Mockito.verify(
			_http
		).URLtoString(
			url
		);
	}

	@Test
	public void testDeleteCommentIfReferrerIsUnreachable() throws Exception {
		String url = RandomTestUtil.randomString();

		Mockito.doThrow(
			IOException.class
		).when(
			_http
		).URLtoString(
			url
		);

		long commentId = RandomTestUtil.randomLong();

		_linkbackConsumer.addNewTrackback(
			commentId, url, RandomTestUtil.randomString());

		_linkbackConsumer.verifyNewTrackbacks();

		Mockito.verify(
			_commentManager
		).deleteComment(
			commentId
		);

		Mockito.verify(
			_http
		).URLtoString(
			url
		);
	}

	@Test
	public void testPreserveCommentIfBlogEntryURLIsInReferrer()
		throws Exception {

		String url = RandomTestUtil.randomString();

		Mockito.when(
			_http.URLtoString(url)
		).thenReturn(
			"__URLtoString_containing_**entryUrl**__"
		);

		_linkbackConsumer.addNewTrackback(
			RandomTestUtil.randomLong(), url, "**entryUrl**");

		_linkbackConsumer.verifyNewTrackbacks();

		Mockito.verifyZeroInteractions(_commentManager);

		Mockito.verify(
			_http
		).URLtoString(
			url
		);
	}

	@Mock
	private CommentManager _commentManager;

	@Mock
	private Http _http;

	private LinkbackConsumer _linkbackConsumer;

}