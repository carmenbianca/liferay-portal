/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.util;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author André de Oliveira
 */
public class SearchOptionalUtil {

	public static <T> void copy(Supplier<Optional<T>> from, Consumer<T> to) {
		Optional<T> optional = from.get();

		optional.ifPresent(to);
	}

	public static <T> T findFirstPresent(
		Stream<Optional<T>> stream, T defaultValue) {

		return stream.filter(
			Optional::isPresent
		).map(
			Optional::get
		).findFirst(
		).orElse(
			defaultValue
		);
	}

}