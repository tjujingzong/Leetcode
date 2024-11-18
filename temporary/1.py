ounts = data.clk.value_counts()
ratio = data.clk.value_counts() / len(data) * 100
data_clk = pd.DataFrame({'Count': counts, 'Ratio(%)': ratio})

# 绘制饼图对广告整体点击情况进行可视化
from pyecharts import options as opts
from pyecharts.charts import Pie
b = data['clk']
b = b.value_counts()
b = dict(b)
b['无点击人数'] = b.pop(0)
b['点击人数'] = b.pop(1)
name = pd.DataFrame(b.keys())
value = pd.DataFrame(b.values())
name = name[0].tolist()
value = value[0].tolist()
words = list(zip(list(name), list(value)))
h = list(zip(list(b.keys()), list(b.values())))
pie = Pie(init_opts=opts.InitOpts(width="500px", height="320px"))
pie.add("", words)
pie.set_global_opts(title_opts=opts.TitleOpts(title="广告整体点击情况", pos_left="40%"),
                    legend_opts=opts.LegendOpts(pos_top="20%", pos_left="80%"))
pie.set_series_opts(label_opts=opts.LabelOpts(formatter="{b}: {c}({d}%)"))
pie.render_notebook()