import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

german_credit = pd.read_csv('D:\Учеба\Системы и технологии интеллектуальной обработки данных\Лабораторная работа №2\german_credit_data.csv')

cols = german_credit.columns[:]
colours = ['#eeeeee','#00ff00']
sns.heatmap(german_credit[cols].isnull(), cmap=sns.color_palette(colours))
plt.show()

print(german_credit.isnull().any())

for col in german_credit.columns:
    countofnull = german_credit[col].isnull().sum()
    print('{} - {}'.format(col, countofnull))

german_credit = german_credit.drop(['Checking account'], axis=1)
print(german_credit.head())

german_credit['Saving accounts'] = german_credit['Saving accounts'].fillna(value=None, method='bfill')
print(german_credit.head())

for col in german_credit.columns:
    countofnull = german_credit[col].isnull().sum()
    print('{} - {}'.format(col, countofnull))

initial_german_credit = pd.read_csv('D:\Учеба\Системы и технологии интеллектуальной обработки данных\Лабораторная работа №2\german_credit_data.csv')

sns.histplot(data=initial_german_credit['Saving accounts'], bins = 10)
plt.show()

sns.histplot(data = german_credit['Saving accounts'], bins = 10)
plt.show()

german_credit["Saving accounts"]=german_credit["Saving accounts"].map({"quite little": 0, "little": 1, "moderate": 2,"rich": 3, "quite rich": 4})
print(german_credit.head())

german_credit["Sex"]=german_credit["Sex"].map({"male": 1, "female": 0})
german_credit["Housing"]=german_credit["Housing"].map({"own": 0, "free": 1, "rent": 2})
print(german_credit.head())

german_credit.to_csv('D:\Учеба\Системы и технологии интеллектуальной обработки данных\Лабораторная работа №2\ew_german_credit_data.csv', index=False)