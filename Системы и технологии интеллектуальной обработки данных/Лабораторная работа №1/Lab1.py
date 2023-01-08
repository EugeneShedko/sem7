#Посмотреть горячие клавиши запуска кода
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
premier_league = pd.read_csv('D:\Учеба\Системы и технологии интеллектуальной обработки данных\Лабораторная работа №1\stats.csv')

print(premier_league['goals'].mean())
print(premier_league[['goals', 'total_yel_card']].median())
print(premier_league[['goals', 'total_yel_card']].describe())
print(premier_league.agg(
    {
    'goals': ['min', 'max', 'mean'],
    'total_yel_card':['min','max','mean']
    }))
print(premier_league['goals'].describe(percentiles=[0.05, 0.25, 0.75, 0.95]))
sns.histplot(data=premier_league['goals'], bins = 10)
plt.show()
print(premier_league[['team','goals']].groupby('team').mean())
print(premier_league.groupby('team').mean())
print(premier_league[['team','season','goals']].groupby(['team','season']).mean())
print(premier_league['team'].value_counts())
sns.boxplot(x=premier_league['goals'])
plt.show()


