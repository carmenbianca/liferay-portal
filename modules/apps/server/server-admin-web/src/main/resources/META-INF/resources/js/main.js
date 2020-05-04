/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-admin',
	A => {
		var Lang = A.Lang;

		var MAP_DATA_PARAMS = {
			classname: 'className',
		};

		var STR_CLICK = 'click';

		var STR_FORM = 'form';

		var STR_URL = 'url';

		var Admin = A.Component.create({
			ATTRS: {
				form: {
					setter: A.one,
					value: null,
				},

				redirectUrl: {
					validator: Lang.isString,
					value: null,
				},

				submitButton: {
					validator: Lang.isString,
					value: null,
				},

				url: {
					value: null,
				},
			},

			AUGMENTS: [Liferay.PortletBase],

			EXTENDS: A.Base,

			NAME: 'admin',

			prototype: {
				_addInputsFromData(data) {
					var instance = this;

					var form = instance.get(STR_FORM);

					var inputsArray = A.Object.map(data, (value, key) => {
						key = MAP_DATA_PARAMS[key] || key;

						var nsKey = instance.ns(key);

						return (
							'<input id="' +
							nsKey +
							'" name="' +
							nsKey +
							'" type="hidden" value="' +
							value +
							'" />'
						);
					});

					form.append(inputsArray.join(''));
				},

				_installXuggler() {
					var instance = this;

					var form = instance.get(STR_FORM);

					var data = A.IO.stringify(form.getDOM());

					data = A.QueryString.parse(data);

					var redirectKey = instance.ns('redirect');

					var url = Liferay.Util.addParams(
						'p_p_isolated=1',
						instance.get(STR_URL)
					);

					data[redirectKey] = Liferay.Util.addParams(
						'p_p_isolated=1',
						data[redirectKey]
					);

					A.one('#adminXugglerPanelContent').load(url, {
						data,
						loadingMask: {
							'strings.loading': Liferay.Language.get(
								'xuggler-library-is-installing'
							),
						},
						selector: '#adminXugglerPanelContent',
						where: 'outer',
					});
				},

				_onSubmit(event) {
					var instance = this;

					var data = event.currentTarget.getData();
					var form = instance.get(STR_FORM);

					var cmd = data.cmd;
					var redirect = instance.one('#redirect', form);

					if (redirect) {
						redirect.val(instance.get('redirectURL'));
					}

					instance._addInputsFromData(data);

					if (cmd === 'installXuggler') {
						var cmdNode = instance.one('#cmd');

						instance._installXuggler();

						if (cmdNode) {
							cmdNode.remove();
						}

						instance._installXuggler();
					}
					else {
						submitForm(form, instance.get(STR_URL));
					}
				},

				bindUI() {
					var instance = this;

					instance._eventHandles.push(
						instance
							.get(STR_FORM)
							.delegate(
								STR_CLICK,
								A.bind('_onSubmit', instance),
								instance.get('submitButton')
							)
					);
				},

				destructor() {
					var instance = this;

					A.Array.invoke(instance._eventHandles, 'detach');

					instance._eventHandles = null;

					A.clearTimeout(instance._laterTimeout);
				},

				initializer() {
					var instance = this;

					instance._eventHandles = [];

					instance.bindUI();
				},
			},
		});

		Liferay.Portlet.Admin = Admin;
	},
	'',
	{
		requires: [
			'aui-io-plugin-deprecated',
			'io',
			'liferay-portlet-base',
			'querystring-parse',
		],
	}
);
