/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.delivery.client.dto.v1_0.BlogPosting;
import com.liferay.portal.search.test.util.SearchTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class BlogPostingResourceTest extends BaseBlogPostingResourceTestCase {

	@Override
	@Test
	public void testPutSiteBlogPostingSubscribe() throws Exception {
		BlogPosting blogPosting =
			testPutSiteBlogPostingSubscribe_addBlogPosting();

		assertHttpResponseStatusCode(
			204,
			blogPostingResource.putSiteBlogPostingSubscribeHttpResponse(
				blogPosting.getSiteId()));
	}

	@Override
	@Test
	public void testPutSiteBlogPostingUnsubscribe() throws Exception {
		BlogPosting blogPosting =
			testPutSiteBlogPostingUnsubscribe_addBlogPosting();

		assertHttpResponseStatusCode(
			204,
			blogPostingResource.putSiteBlogPostingUnsubscribeHttpResponse(
				blogPosting.getSiteId()));
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"articleBody", "description", "headline"};
	}

	@Override
	protected String[] getIgnoredEntityFieldNames() {
		return new String[] {"creatorId"};
	}

}