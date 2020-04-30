/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.batch;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.search.batch.BatchIndexingHelper;
import com.liferay.portal.search.configuration.ReindexConfiguration;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Bryan Engler
 * @author André de Oliveira
 */
@Component(
	configurationPid = "com.liferay.portal.search.configuration.ReindexConfiguration",
	immediate = true, service = BatchIndexingHelper.class
)
public class BatchIndexingHelperImpl implements BatchIndexingHelper {

	@Override
	public int getBulkSize(String entryClassName) {
		Optional<Integer> optional = Stream.of(
			_reindexConfiguration.indexingBatchSizes()
		).map(
			line -> StringUtil.split(line, StringPool.EQUAL)
		).filter(
			pair -> pair.length == 2
		).filter(
			pair -> entryClassName.equals(pair[0])
		).map(
			pair -> GetterUtil.getInteger(pair[1])
		).findAny();

		return optional.orElse(Indexer.DEFAULT_INTERVAL);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_reindexConfiguration = ConfigurableUtil.createConfigurable(
			ReindexConfiguration.class, properties);
	}

	private ReindexConfiguration _reindexConfiguration;

}