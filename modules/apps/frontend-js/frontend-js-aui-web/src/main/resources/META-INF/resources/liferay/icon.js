/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * The Icon Component.
 *
 * @deprecated since 7.2, unused
 * @module liferay-icon
 */

AUI.add(
	'liferay-icon',
	A => {
		var _ICON_REGISTRY = {};

		var Icon = {
			_forcePost(event) {
				if (!Liferay.SPA || !Liferay.SPA.app) {
					Liferay.Util.forcePost(event.currentTarget);

					event.preventDefault();
				}
			},

			_getConfig(event) {
				return _ICON_REGISTRY[event.currentTarget.attr('id')];
			},

			_handleDocClick(event) {
				var instance = this;

				var config = instance._getConfig(event);

				if (config) {
					event.preventDefault();

					if (config.useDialog) {
						instance._useDialog(event);
					}
					else {
						instance._forcePost(event);
					}
				}
			},

			_handleDocMouseOut(event) {
				var instance = this;

				var config = instance._getConfig(event);

				if (config && config.srcHover) {
					instance._onMouseHover(event, config.src);
				}
			},

			_handleDocMouseOver(event) {
				var instance = this;

				var config = instance._getConfig(event);

				if (config && config.srcHover) {
					instance._onMouseHover(event, config.srcHover);
				}
			},

			_onMouseHover(event, src) {
				var img = event.currentTarget.one('img');

				if (img) {
					img.attr('src', src);
				}
			},

			_useDialog(event) {
				Liferay.Util.openInDialog(event, {
					dialog: {
						destroyOnHide: true,
					},
					dialogIframe: {
						bodyCssClass: 'dialog-with-footer',
					},
				});
			},

			register(config) {
				var instance = this;

				var doc = A.one(A.config.doc);

				_ICON_REGISTRY[config.id] = config;

				if (!instance._docClickHandler) {
					instance._docClickHandler = doc.delegate(
						'click',
						instance._handleDocClick,
						'.lfr-icon-item',
						instance
					);
				}

				if (!instance._docHoverHandler) {
					instance._docHoverHandler = doc.delegate(
						'hover',
						instance._handleDocMouseOver,
						instance._handleDocMouseOut,
						'.lfr-icon-item',
						instance
					);
				}

				Liferay.once('screenLoad', () => {
					delete _ICON_REGISTRY[config.id];
				});
			},
		};

		Liferay.Icon = Icon;
	},
	'',
	{
		requires: ['aui-base', 'liferay-util-window'],
	}
);
