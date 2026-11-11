# DataFest 2024 (SMU)

My code from ASA DataFest 2024 at Southern Methodist University, a weekend data analysis competition for undergraduates. The dataset was anonymized student usage data from CourseKata, an online statistics textbook.

## Goal

We looked at how practice attempts, time spent reading and self-reported motivation relate to students' end-of-chapter (EOC) review scores.

## What the code does

`DataFestCheckpointsEOC.java` reads three data files and combines them into one record per student. For each of the 16 chapters, the record holds the student's EOC score, number of attempts, active reading time and motivation survey ratings. The program can then print a report for one student or export tables to CSV for charting.

Example output:

```
Student: faa80c7f-4baa-4a70-abb0-867ad4d78138
Book: College / Statistics and Data Science (ABC)

Chapter 1:
Time: 4818727
Attempts: 899
EOC: 0.4358974358974359
...
```

## Data

The data files are not included in this repository because CourseKata provided them for DataFest. They covered 1,565 students in 48 classes:

- `checkpoints_eoc.csv`: EOC scores and attempts
- `checkpoints_pulse.csv`: motivation survey responses
- `page_views.csv`: page visits and reading time (about 480,000 rows)

## Initial observation

The number of attempts and EOC scores were only weakly related (r ≈ −0.10), so more practice alone did not mean higher scores.

## Running

The program needs the data files above, placed in the working directory, and Java 8 or later:

```
javac DataFestCheckpointsEOC.java
java DataFestCheckpointsEOC
```

## Limitations

This was written during a 48-hour competition. With more time, I would clean up the code structure and fit a model that uses attempts, time and motivation together.
