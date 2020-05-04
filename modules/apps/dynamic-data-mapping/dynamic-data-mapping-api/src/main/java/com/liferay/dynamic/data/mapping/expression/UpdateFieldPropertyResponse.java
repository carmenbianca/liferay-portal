/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression;

/**
 * @author Leonardo Barros
 */
public final class UpdateFieldPropertyResponse {

	public boolean isUpdated() {
		return _updated;
	}

	public static class Builder {

		public static Builder newBuilder(boolean updated) {
			return new Builder(updated);
		}

		public UpdateFieldPropertyResponse build() {
			return _updateFieldPropertyResponse;
		}

		private Builder(boolean updated) {
			_updateFieldPropertyResponse._updated = updated;
		}

		private final UpdateFieldPropertyResponse _updateFieldPropertyResponse =
			new UpdateFieldPropertyResponse();

	}

	private UpdateFieldPropertyResponse() {
	}

	private boolean _updated;

}