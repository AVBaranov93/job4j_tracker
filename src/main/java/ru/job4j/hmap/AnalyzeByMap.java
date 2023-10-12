package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                count++;
            }
        }
        return sumScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            int count = 0;
            double sumScore = 0D;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                count++;
            }
            labels.add(new Label(pupil.name(), sumScore / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (k, v) ->
                        map.get(subject.name()) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            labels.add(new Label(key, map.get(key) / count));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0D;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            labels.add(new Label(pupil.name(), sumScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            labels.add(new Label(key, map.get(key)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
