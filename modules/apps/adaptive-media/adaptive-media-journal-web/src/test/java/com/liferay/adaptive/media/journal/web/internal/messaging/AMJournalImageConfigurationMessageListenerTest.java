/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.journal.web.internal.messaging;

import com.liferay.journal.util.JournalContent;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.test.ReflectionTestUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Alejandro Tardín
 */
@RunWith(MockitoJUnitRunner.class)
public class AMJournalImageConfigurationMessageListenerTest {

	@Before
	public void setUp() {
		ReflectionTestUtil.setFieldValue(
			_amJournalImageConfigurationMessageListener, "_journalContent",
			_journalContent);
	}

	@Test
	public void testClearsTheCacheOnAMessageToTheConfigurationDestination()
		throws Exception {

		_amJournalImageConfigurationMessageListener.doReceive(new Message());

		Mockito.verify(
			_journalContent, Mockito.times(1)
		).clearCache();
	}

	private final AMJournalImageConfigurationMessageListener
		_amJournalImageConfigurationMessageListener =
			new AMJournalImageConfigurationMessageListener();

	@Mock
	private JournalContent _journalContent;

}