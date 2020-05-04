/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.asset.list.constants.AssetListEntryTypeConstants;
import com.liferay.asset.list.model.AssetListEntry;
import com.liferay.asset.list.service.AssetListEntryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.headless.delivery.client.dto.v1_0.ContentSetElement;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.search.test.util.SearchTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class ContentSetElementResourceTest
	extends BaseContentSetElementResourceTestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		_serviceContext = new ServiceContext();

		_serviceContext.setScopeGroupId(testGroup.getGroupId());

		long userId = TestPropsValues.getUserId();

		_serviceContext.setUserId(userId);

		_assetListEntry = AssetListEntryLocalServiceUtil.addAssetListEntry(
			userId, testGroup.getGroupId(), RandomTestUtil.randomString(),
			AssetListEntryTypeConstants.TYPE_DYNAMIC, _serviceContext);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Override
	protected ContentSetElement
			testGetContentSetContentSetElementsPage_addContentSetElement(
				Long contentSetId, ContentSetElement contentSetElement)
		throws Exception {

		return _toContentSetElement(_addBlogsEntry());
	}

	@Override
	protected Long testGetContentSetContentSetElementsPage_getContentSetId() {
		return _assetListEntry.getAssetListEntryId();
	}

	@Override
	protected ContentSetElement
			testGetSiteContentSetByKeyContentSetElementsPage_addContentSetElement(
				Long siteId, String key, ContentSetElement contentSetElement)
		throws Exception {

		return _toContentSetElement(_addBlogsEntry());
	}

	@Override
	protected String testGetSiteContentSetByKeyContentSetElementsPage_getKey() {
		return _assetListEntry.getAssetListEntryKey();
	}

	@Override
	protected ContentSetElement
			testGetSiteContentSetByUuidContentSetElementsPage_addContentSetElement(
				Long siteId, String uuid, ContentSetElement contentSetElement)
		throws Exception {

		return _toContentSetElement(_addBlogsEntry());
	}

	@Override
	protected String
		testGetSiteContentSetByUuidContentSetElementsPage_getUuid() {

		return _assetListEntry.getUuid();
	}

	private BlogsEntry _addBlogsEntry() throws PortalException {
		return BlogsEntryLocalServiceUtil.addEntry(
			UserLocalServiceUtil.getDefaultUserId(testGroup.getCompanyId()),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			_serviceContext);
	}

	private ContentSetElement _toContentSetElement(BlogsEntry blogsEntry) {
		return new ContentSetElement() {
			{
				id = blogsEntry.getEntryId();
				title = blogsEntry.getTitle();
			}
		};
	}

	private AssetListEntry _assetListEntry;
	private ServiceContext _serviceContext;

}